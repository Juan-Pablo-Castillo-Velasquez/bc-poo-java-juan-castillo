#!/bin/bash

# -----------------------------
# CONFIGURACIÓN
# -----------------------------
REPO_DIR="$(dirname "$0")/.."
LOG_FILE="$REPO_DIR/logs/autocommit.log"
BRANCH="main"
GIT_USER="Juan Pablo Castillo Velasquez"
GIT_EMAIL="juanpablo207k@gmail.com"


mkdir -p "$REPO_DIR/logs"
cd "$REPO_DIR" || exit

# Configurar git si no está configurado
git config user.name "$GIT_USER"
git config user.email "$GIT_EMAIL"

# Función para log con fecha y hora
log() {
    echo "[$(date '+%Y-%m-%d %H:%M:%S')] $1" >> "$LOG_FILE"
}

log "=== Iniciando auto-commit ==="

# Verifica cambios
CHANGES=$(git status --porcelain)

if [ -z "$CHANGES" ]; then
    log "No hay cambios para commitear 😴"
else
    git add -A

    # Analizar tipo de cambio
    ADDED=$(echo "$CHANGES" | grep '^A' | wc -l)
    MODIFIED=$(echo "$CHANGES" | grep '^ M' | wc -l)
    DELETED=$(echo "$CHANGES" | grep '^ D' | wc -l)

    WHAT="Archivos modificados"
    FOR="Mantener el repositorio actualizado"
    IMPACT="Evita perder cambios y mantiene historial"

    SUMMARY=""
    [ "$ADDED" -gt 0 ] && SUMMARY+="➕ Agregados: $ADDED. "
    [ "$MODIFIED" -gt 0 ] && SUMMARY+="✏️ Modificados: $MODIFIED. "
    [ "$DELETED" -gt 0 ] && SUMMARY+="❌ Borrados: $DELETED. "

    COMMIT_MSG="Auto-commit $(date '+%Y-%m-%d %H:%M:%S') | $SUMMARY

What? $WHAT
For? $FOR
Impact? $IMPACT

🤖 Auto-committed by script"

    if git commit -m "$COMMIT_MSG"; then
        log "✅ Commit realizado: $SUMMARY"

        # Push al repositorio remoto
        if git push origin "$BRANCH" 2>&1 | tee -a "$LOG_FILE"; then
            log "✅ Push exitoso 👍"
        else
            log "⚠️ Push fallido, se intentará la próxima vez"
        fi
    else
        log "❌ Commit fallido ⚠️"
    fi
fi

log "=== Auto-commit finalizado ==="
echo "" >> "$LOG_FILE"
