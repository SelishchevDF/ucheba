def read_from_file(path):
    with open(path, "r") as f:
        val = f.read()
    return val