#!/bin/bash

# Store the project directory name.
TASK_NUM="$1"
SRC_DIR="java/app/src/main/java/org/bloku/task/_$TASK_NUM"

# Create the main project directory and subdirectories.
mkdir -p "$SRC_DIR"
if [ $? -ne 0 ]; then
    echo "Error: Failed to create source directory '$SRC_DIR'."
    exit 1
fi

# Define the source and test file names.
SRC_FILE_NAME="Solution.java"

# --- Create the source file (Solution.java) ---
SRC_PATH="$SRC_DIR/$SRC_FILE_NAME"
if [ -f "$SRC_PATH" ]; then
    echo "Warning: The file '$SRC_PATH' already exists. Skipping."
else
    cat <<'EOF' >"$SRC_PATH"
package org.bloku.task.TODO;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("") // TODO
@Topics({}) // TODO
class Solution {

    public int f() {
        return -1;
    }
}

EOF
    if [ $? -eq 0 ]; then
        echo "Successfully created '$SRC_PATH' with the template content."
    else
        echo "An error occurred while creating the file '$SRC_PATH'."
    fi
fi
