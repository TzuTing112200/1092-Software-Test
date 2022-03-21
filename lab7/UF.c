#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main()
{
  char *str = malloc(4);
  free(str);

  printf("%s\n", str);

  return 0;
}
