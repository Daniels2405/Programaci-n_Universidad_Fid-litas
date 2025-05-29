#include <pthread.h>
#include <stdio.h>
void* mensaje(void* arg) {
    printf("Hola desde un hilo POSIX\n");
    return NULL;
}
int main() {
    pthread_t hilo;
    pthread_create(&hilo, NULL, mensaje, NULL);
    pthread_join(hilo, NULL);
    return 0;
}