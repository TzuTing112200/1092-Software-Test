#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BUFSIZE 8

int main(int argc, char **argv) {
  char *buf;
  buf = (char *)malloc(sizeof(char)*BUFSIZE);
  strcpy(buf, argv[1]);

  return 0;
}
