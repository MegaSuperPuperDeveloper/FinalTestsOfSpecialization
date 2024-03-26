from csv import DictWriter, DictReader
import os
import datetime
from os.path import exists

# Cоздание заметки
def createFile(fileName): 
    with open(fileName + ".csv", 'w', encoding="utf-8") as file:
        writer = DictWriter(file, fieldnames=["Дата создания: " + str(datetime.datetime.utcnow())])
        writer.writeheader()
        writer = DictWriter(file, fieldnames=[input("Введите заголовок: ").upper()])
        writer.writeheader()

# Чтение заметки
def readFile(fileName):
    with open(fileName + ".csv", 'r', encoding="utf-8") as file:
        reader = DictReader(file)
        for line in file:
            print(line)

# Печать внутри заметки
def writeFile(fileName):
    with open(fileName + ".csv", 'a', encoding="utf-8", newline='') as file:
        command = input()
        if command != "!stop":
            writer = DictWriter(file, fieldnames=[command])
            writer.writeheader()
        return command

# Удаление заметки
def deleteFile(fileName):
    os.remove(fileName + ".csv")

# Меню взаимодействия с разными заметками
while True:
    command = input("Введите команду: ")
    if command == "add":
        fileName = input("Введите название заметки: ")
        if exists(fileName + ".csv"):
            print("Ошибка! Заметка с таким названием уже есть!")
        else:
            createFile(fileName)
    elif command == "read":
        fileName = input("Введите название заметки: ")
        if exists(fileName + ".csv"):
            readFile(fileName)
        else:
            print("Ошибка! Заметки с таким названием нет!")
    elif command == "delete":
        fileName = input("Введите название заметки: ")
        if exists(fileName + ".csv"):
            deleteFile(fileName)
        else:
            print("Ошибка! Заметки с таким названием нет!")
    elif command == "write":
        fileName = input("Введите название заметки: ")
        if exists(fileName + ".csv"):
            while command != "!stop":
                command = writeFile(fileName)
        else:
            print("Ошибка! Заметки с таким названием нет!")
    elif command == "help":
        print("add - создание новой заметки")
        print("read - получение содержимого заметки")
        print("delete - удаление заметки")
        print("write - добавление новой строки")
        print("!stop - команда для остановки печати в заметке")
    else:
        print("Введена некорректная команда! Для получения списка команд,")
        print("Напишите команду help.")