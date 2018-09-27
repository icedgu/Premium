---
All works were commited by Hyojin Kim.

Text Classification baed on LSTM on tesing environmnet document.
---

### 1. Details of file fold:
- data/
- data/train_txt/*.txt
- data/train_txt.txt
- data/train_label.txt
- data/test_txt/*.txt
- data/test_txt.txt
- data/test_label.txt

### 2. File description:

| file | description|
|---|---|
|data/train_txt/|training text fold|
|data/test_txt/|testing text fold|
|data/train_txt.txt|file name list for training text |
|data/test_txt.txt|file name list for testing text |
|data/train_label.txt|label list for training text|
|data/test_label.txt| label list for testing text|

### 3. Running example:
Environment: python 3

Requirements:
```python
pytorch
```
running example:
```python
python main.py
```
output:
![](./figure/LSTM_classifier_example.png)

### 4. Dataset:
Our dataset was a document file defining an environment of ICT(information Communication Tech.)testing case.
Original file cannot be uploaded though. 
