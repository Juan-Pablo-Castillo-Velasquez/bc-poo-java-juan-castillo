#!/bin/bash

# Ir a la raíz del repositorio
cd "$(dirname "$0")/.." || exit

# Solo hacer commit si hay cambios
if ! git diff-index --quiet HEAD --; then
    git add .
    git commit -m "Auto-commit $(date '+%Y-%m-%d %H:%M:%S')"
    git push origin main
fi
