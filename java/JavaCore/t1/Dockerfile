FROM openjdk
COPY ./src ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/t1app/mainclass/Main.java
CMD java -classpath ./out t1app.mainclass.Main