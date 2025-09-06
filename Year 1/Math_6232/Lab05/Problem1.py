def convert(GB):
    print("Gigabytes (GB) : " + str(GB))
    print("Megabytes (MB) : " + str(GB*1024))
    print("Kilobytes (KB) : " + str(GB*1024**2))
    print("Bytes : " + str(GB*1024**3))
    print("Bits : " + str(GB*(1024**3)*8))

convert(float(input()))