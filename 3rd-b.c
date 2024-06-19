#include <stdio.h>
#include <string.h>
#include <ctype.h>

void encrypt(char *plaintext, int rails, char *encryptedText) {
    char railArray[rails][strlen(plaintext)];
    for (int i = 0; i < rails; i++) {
        memset(railArray[i], '\0', strlen(plaintext));
    }

    int railIndex = 0;
    int down = 1; // boolean value in C: 1 for true, 0 for false
    int i = 0;
    while (plaintext[i] != '\0') {
        railArray[railIndex][i] = plaintext[i];
        if (down) {
            railIndex++;
        } else {
            railIndex--;
        }
        if (railIndex == rails - 1 || railIndex == 0) {
            down = !down;
        }
        i++;
    }

    int pos = 0;
    for (int row = 0; row < rails; row++) {
        for (int col = 0; col < strlen(plaintext); col++) {
            if (railArray[row][col] != '\0') {
                encryptedText[pos++] = railArray[row][col];
            }
        }
    }
    encryptedText[pos] = '\0'; // Null-terminate the string
}

void decrypt(char *encryptedText, int rails, char *decryptedText) {
    int len = strlen(encryptedText);
    char railArray[rails][len];
    for (int i = 0; i < rails; i++) {
        memset(railArray[i], '\0', len);
    }

    int railIndex = 0;
    int down = 1;
    int i = 0;

    // Mark the positions in the rail array
    for (i = 0; i < len; i++) {
        railArray[railIndex][i] = '*';
        if (down) {
            railIndex++;
        } else {
            railIndex--;
        }
        if (railIndex == rails - 1 || railIndex == 0) {
            down = !down;
        }
    }

    // Fill the rail array with the encrypted text
    int pos = 0;
    for (int row = 0; row < rails; row++) {
        for (int col = 0; col < len; col++) {
            if (railArray[row][col] == '*' && pos < len) {
                railArray[row][col] = encryptedText[pos++];
            }
        }
    }

    // Read the rail array to construct the decrypted text
    railIndex = 0;
    down = 1;
    for (i = 0; i < len; i++) {
        decryptedText[i] = railArray[railIndex][i];
        if (down) {
            railIndex++;
        } else {
            railIndex--;
        }
        if (railIndex == rails - 1 || railIndex == 0) {
            down = !down;
        }
    }
    decryptedText[len] = '\0'; // Null-terminate the string
}

int main() {
    char plaintext[100], encryptedText[100], decryptedText[100];
    int rails;

    printf("Enter plaintext: ");
    fgets(plaintext, sizeof(plaintext), stdin);
    plaintext[strcspn(plaintext, "\n")] = '\0'; // Remove newline character

    printf("Enter number of rails: ");
    scanf("%d", &rails);

    encrypt(plaintext, rails, encryptedText);
    printf("Encrypted text: %s\n", encryptedText);

    decrypt(encryptedText, rails, decryptedText);
    printf("Decrypted text: %s\n", decryptedText);

    return 0;
}
