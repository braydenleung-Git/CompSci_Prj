#!/bin/bash
if ! command -v java >/dev/null 2>&1; then
    read -p "Java is not found. Install? [Y/N] " input
    if [[ ${input^^} == "Y" ]]; then
        echo "Installing..."
        if command -v brew >/dev/null 2>&1; then
            brew install java
        else
            read -p "Brew is not found. Install? [Y/N] " input_1
            if [[ ${input_1^^} == "Y" ]]; then
                echo "Installing Brew..."
                /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
                brew install java
            else
                echo "Exiting program: No Brew installed on the system."
                exit
            fi
        fi
    else
        echo "Exiting program: No Java installed on the system."
        exit
    fi
fi
cd "$(dirname "$0")"
java -jar CompSci_Prj*.jar