#include<stdio.h> 

#include<stdlib.h> 

#include<string.h> 

void main(){ 

    char str[]="Hello World"; 

    int len=strlen(str); 

    char str1[11],str2[12],str3[13]; 

 

    printf("original string is %s \n",str); 

    printf("after and op \n"); 

    for(int i=0;i<len;i++){ 

    printf("%c=%d \n",str[i],str[i]&127); 

} 

printf("after or op\n"); 

for(int i=0;i<len;i++){ 

printf("%c=%d \n",str[i],str[i]|127); 

} 

printf("after XOR op \n"); 

for(int i=0;i<len;i++){ 

printf("%c=%d\n",str[i],str[i]^127); 

} 

}
