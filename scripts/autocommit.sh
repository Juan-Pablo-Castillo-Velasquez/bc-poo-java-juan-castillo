#!/bin/bash

cd "$(dirname "$0")/.." || exit

if ! git diff-index --quiet HEAD --; then
    git add .
    git commit -m "Auto-commit $(date '+%Y-%m-%d %H:%M:%S')"
    git push origin main
fi
