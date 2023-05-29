# В большой текстовой строке подсчитать количество встречаемых слов и вернуть 10 самых частых. 
# Не учитывать знаки препинания и регистр символов. 
# За основу возьмите любую статью из википедии или из документации к языку.
import string

with open('txt.txt', encoding='utf-8') as f:
    text = f.read()
  
res = [word.strip(string.punctuation) for word in text.split() if word.strip(string.punctuation).isalnum()]  

word_counter = {}
for word in res:
    if len(word) > 0 and word != '\r\n':
        if word not in word_counter: 
            word_counter[word] = 1
        else:
            word_counter[word] += 1 

for i,word in enumerate(sorted(word_counter,key=word_counter.get,reverse=True)[:10]):
    print("%s: %s - %s"%(i+1,word,word_counter[word]))