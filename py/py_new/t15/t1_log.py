import datetime


class MyLogger:
    
    def write_start(self, value):
        with open("log.txt", "a", encoding="utf-8") as file:
            time = datetime.datetime.now()
            file.write("\n")
            file.write(f"start at {time.hour}:{time.minute}:{time.second} with param {value}\n")
            
    def write_error(self, value):
        with open("log.txt", "a", encoding="utf-8") as file:
            time = datetime.datetime.now()
            file.write(f"break at {time.hour}:{time.minute}:{time.second} with exception {value}\n")
            
    def write_stop(self, value):
        with open("log.txt", "a", encoding="utf-8") as file:
            time = datetime.datetime.now()
            file.write(f"stop at {time.hour}:{time.minute}:{time.second} with result {value}\n")