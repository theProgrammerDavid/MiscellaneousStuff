# Linux Kernel Stuff

## Installation steps

- apt-get install build-essential linux-headers-\$(uname -r)

- Add the compiled kernel module to the kernel with

```bash
sudo insmod hello.ko
```

- View the output with

```bash
dmesg | tail -l
```

- remove the kernel module with

```bash
rmmod hello.ko
```

- View the output with

```bash
dmesg | tail -l
```
