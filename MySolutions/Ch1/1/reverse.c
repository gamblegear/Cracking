#include <stdio.h>

int main(int argc, char* argv[]) {
	printf("%d\n", argc);
	printf("%s\n", argv[0]);

	if(!argv[1]) {
		printf("*********\n");
		return -1;
	}

	char* end;
	char* str;
	char tmp;
	int cnt = 0;

	end = argv[1];
	str = argv[1];

	while(*end)
		end++;
	end--;

	printf("%c\n", *end);

	while(str < end) {
		printf("## %c, %c\n", *str, *end);

		tmp = *end;
		*end-- = *str;
		*str++ = tmp;
		cnt++;
	}

	printf("test\n");
	printf("%s\n", argv[1]);
	return 0;
}
