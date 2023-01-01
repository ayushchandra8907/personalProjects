def mortalRabbit(n):
    if n == 1 or n == 2:
        return 1
    else:
        return mortalRabbit(n-1)+mortalRabbit(n-2)


print(mortalRabbit(2))