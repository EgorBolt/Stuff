﻿Программа написана на Java (требуется версия 8 или выше).



Программа в папке sort_boldyrev разбита на следующие папки:

bin/ - здесь находятся скомпилированные исходники, готовые к запуску, а также
	серия лёгких тестов для проверки работоспособности программы, где in1.txt, ..., in5.txt - файлы с целыми числами,
in6.txt, ..., in10.txt - файлы со строками, out.txt - файл, куда программа записывает результат.

src/ - здесь находятся непосредственно исходники программы


Если вы хотите скомпилировать программу в другом месте, то (предполагается, что все действия выполняются
в командной строке, инструкция приведена для ОС на базе Linux, для OC Windows данная инструкция тоже
подходит с точностью до команд для командной строки):
    
	1. Перейдите в папку archive_boldyrev
    
	2. Выполните команду javac -sourcepath ./src -d path/to/your/folder src/Main.java
    
	где path/to/your/folder - место, где вы желаете иметь скомпилированную программу
    
	3. Перейдите в path/to/your/folder и выполните команду java Main parameters...
    
	где parameters... - параметры программы согласно тексту задания, не забудьте указать либо полные пути
 до файлов, которые надо отсортировать, либо положить эти файлы в path/to/your/folder



Т.к. в bin/ лежит уже скомпилированная программа, то для примера работы перейдите в папку bin/ и можно выполнить 
	java Main -i -d out.txt in1.txt in2.txt in3.txt in4.txt in5.txt

ИЛИ
     java Main -s out.txt in6.txt in7.txt in8.txt in9.txt in10.txt
