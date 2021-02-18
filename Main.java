package LibraryProject;

import SchoolProject.Employee.Employee;
import SchoolProject.Employee.Teathers;

import javax.print.attribute.standard.Fidelity;
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static ArrayList<Books> listBook;
    public static ArrayList<Reader> listReader;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Books> lidraries = new ArrayList<>();
    public static ArrayList<Reader> peopleReader = new ArrayList<>();

    public static void main(String[] args) throws IOException {



        //Добавлений книг
        listBook = new ArrayList<>();
        //добавлений читателей

        listReader = new ArrayList<>();

        Lidrary lidrary = new Lidrary(listReader, listBook);
        try {
            FileInputStream inputStream = new FileInputStream("lidery");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            lidraries = (ArrayList<Books>) objectInputStream.readObject();

            objectInputStream.close();

        } catch (Exception e) {

        }

        try {
            FileInputStream inputStream = new FileInputStream("people");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            peopleReader = (ArrayList<Reader>) objectInputStream.readObject();
            objectInputStream.close();

        } catch (Exception e) {

        }

        outh();
    }



    //Главный меню
    public static void outh() throws IOException {
        System.out.println();
        while (true) {
            try {
                System.out.println();
                System.out.println("1. Поиск книг");
                System.out.println("2. Просмотр доступных книг");
                System.out.println("3. Просмотр пользователей");
                System.out.println("4. Просмотр взятых книг");
                System.out.println("5. Добавить книгу");
                System.out.println("6. Зарегистрироваться");
                System.out.println("7. Автаризация");
                System.out.println("8. Выход");
                int answer = Integer.parseInt(reader.readLine());
                switch (answer) {
                    case 1:
                        Bookkey();
                        break;
                    case 2:
                        lookBook();
                        break;
                    case 3:
                        lookReader();
                        break;
                    case 4:
                        readerBook();
                        break;
                    case 5:
                        AddBooks();
                        break;
                    case 6:
                        infoBooks();
                        break;
                    case 7:
                        AuthorizationReader();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }
    }

    //1:    //Поиск книг
    public static void Bookkey() throws IOException {
        System.out.println();
        System.out.println("укажите названия книги");
        String name = reader.readLine();
        StringBuilder builder = new StringBuilder();
        StringBuilder builderBook = new StringBuilder();
        builderBook.append(name);
        String st = "";
        int count = 0;
        int temp = 0;
        boolean bag = false;
        ArrayList<Books> comentary = new ArrayList<>();
        for (Books books : lidraries) {
            if (count == 0) {
                for (int i = 0; i < name.length(); i++) {
                    if (i == 0) {
                        st = (String.valueOf(name.charAt(i)));
                        builder.append(st.toUpperCase());
                    } else {
                        builder.append(String.valueOf(name.charAt(i)));
                    }
                }
            }
            count++;
            if (books.getName().matches("(.*)" + builder + "(.*)")||books.getName().matches("(.*)" + builderBook + "(.*)")) {
                System.out.println("№"+count +". " + books.getName() + " автор книги " + books.getAuthor() + " жаныр " + books.getZhanyr());
                bag = true;
                comentary.add(books);
                temp = count;
            }else if (books.getAuthor().matches("(.*)" + builder + "(.*)")||books.getAuthor().matches("(.*)" + builderBook + "(.*)")) {
                System.out.println("№" + count +". "+books.getName() + " автор " + books.getAuthor() + " жаныр " + books.getZhanyr());
                bag = true;
                comentary.add(books);
                temp = count;
            }
        }
        if (!bag) {
            System.out.println("Таких книг у нас есть");
            while (true) {
                System.out.println("-----------------");
                System.out.println("Вернутся в главный меню? 1 - Да");
                try {
                    int answer = Integer.parseInt(reader.readLine());
                    if (answer == 1) {
                        outh();
                    }
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Вы ввели не цывру");
                    System.out.println("Введите цыфру");
                }
            }
        }
        while (true) {
            System.out.println("-----------------");
            System.out.println("Вернутся в главный меню? 1 - Да");
            System.out.println("Хотите посмотрет коментарий 2 - Да");
            System.out.println("Хотите взять книгу автаризуйтесь? 3 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer == 1) {
                    outh();
                }else if (answer == 2){
                    System.out.println("Напишите номер книги");
                    int number = Integer.parseInt(reader.readLine());
                    count = 0;
                    String name1 = "";
                    try {
                        for (Books books : lidraries) {
                            count++;
                            name1 = books.getName();
                            if (count == number) {
                                for (int i = 0; i < comentary.size(); i++) {
                                    if (name1.equals(comentary.get(i).getName())) {
                                        if (temp >= count) {
                                            System.out.println("Книга " + books.getName());
                                            if (books.getComent().size() >= -1) {
                                                System.out.println("Все коментарий");
                                                for (String books1 : books.getComent()) {
                                                    System.out.println(books1);
                                                }
                                            } else {
                                                System.out.println("Коментарий нет!");
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }catch (NullPointerException e){
                        System.out.println("Каминтарий нет");
                    }
                    while (true) {
                        System.out.println("-----------------");
                        System.out.println("Вернутся в главный меню? 1 - Да");
                        try {
                            int answer1 = Integer.parseInt(reader.readLine());
                            if (answer1 == 1) {
                                outh();
                            }
                        }catch (NumberFormatException e){
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");
                        }
                    }
                }else if (answer == 3) {
                    AuthorizationReader();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }

    }

    //2:    //смотр доступных книг
    public static void lookBook() throws IOException {
        System.out.println();
        System.out.println("здравствуйте");
        System.out.println("доступные книги");
        System.out.println("----------------");
        int num = 0;
        int count = 0;
        int temp = 0;
        ArrayList<Books> comentary = new ArrayList<>();
        for (Books books : lidraries) {
            count++;
            if (books.isInStock()) {
                System.out.println("№." + count + " " + books.getName() + " автор книги " + books.getAuthor() +
                        " жаныр: " + books.getZhanyr() + " |нравится " + books.getLike()
                        + " |не нравится " + books.getDontLike());
                temp = count;
                comentary.add(books);
            }
        }

        while (true) {
            System.out.println("-----------------");
            System.out.println("Вернутся в главный меню? 1 - Да");
            System.out.println("Хотите посмотреть коментарий? 2 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer == 1) {
                    outh();
                } else if (answer == 2) {
                    System.out.println("Напишите номер книги");
                    int number = Integer.parseInt(reader.readLine());
                    count = 0;
                    String name = "";
                    try {
                        for (Books books : lidraries) {
                            count++;
                            name = books.getName();
                            if (count == number) {
                                for (int i = 0; i < comentary.size(); i++) {
                                    if (name.equals(comentary.get(i).getName())) {
                                        if (temp >= count) {
                                            System.out.println("Книга " + books.getName());
                                            if (books.getComent().size() >= -1) {
                                                System.out.println("Все коментарий");
                                                for (String books1 : books.getComent()) {
                                                    System.out.println(books1);
                                                }
                                            } else {
                                                System.out.println("Коментарий нет!");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }catch (NullPointerException e){
                        System.out.println("Коментарий нет");
                    }
                    while (true) {
                        System.out.println("-----------------");
                        System.out.println("Вернутся в главный меню? 1 - Да");
                        try {
                            int answer1 = Integer.parseInt(reader.readLine());
                            if (answer1 == 1) {
                                outh();
                            }
                        }catch (NumberFormatException e){
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }

        }
    }

    //3:    //Прасмотр пользователя книг
    public static void lookReader() throws IOException {
        System.out.println();
        System.out.println("Здарвствуйте");
        System.out.println("Все пользователи");
        System.out.println("-----------------------");
        for (Reader readerPeople : peopleReader) {
            if (readerPeople instanceof Student){
                Student student = (Student) readerPeople;
                System.out.println("Студент " + student.getName() + " логин: " + student.getLogin() + " пароль: " + student.getPassword());
            }
            if (readerPeople instanceof Teacher) {
                Teacher teacher = (Teacher) readerPeople;
                System.out.println("учитель " + teacher.getName() + " логин: " + teacher.getLogin() + " пароль: " + teacher.getPassword());
            }

        }
        while (true) {
            System.out.println("-----------------");
            System.out.println("Вернутся в главный меню? 1 - Да");
            System.out.println("Хотите взять книгу автаризуйтесь? 2 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer == 1) {
                    outh();
                } else if (answer == 2) {
                    AuthorizationReader();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }

        }

    }

    //4:     //Прасмотр взятых книг
    public static void readerBook() throws IOException {
        System.out.println();
        System.out.println("Здравствуйте книги кторые заняты");
        int count = 0;
        for (Books books : lidraries) {
            if (!books.isInStock()) {
                System.out.println(books.getName() + " автор книги " + books.getAuthor() + " взял книгу " + books.getUser().getName());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Занитые книги нет");
        }
        while (true) {
            System.out.println("-----------------");
            System.out.println("Вернутся в главный меню? 1 - Да");
            System.out.println("Хотите взять книгу автаризуйтесь? 2 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer == 1) {
                    outh();
                } else if (answer == 2) {
                    AuthorizationReader();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }

        }

    }

    //5: Добавит книгу
    public static void AddBooks() throws IOException {
        System.out.println("Здравствуйте");
        while (true) {
            System.out.println("Вы правда хотите добавить книгу? 1 - Да");
            System.out.println("Вернутся в главный меню? 2 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer == 1) {
                    System.out.println("Введите имя книги");
                    String nameBook = reader.readLine();
                    System.out.println("Введите автор книги");
                    String aothe = reader.readLine();
                    System.out.println("Введите жаныр");
                    String zhanyr = reader.readLine();
                    lidraries.add(new Books(generetyID(), nameBook, true, aothe, zhanyr));
                    System.out.println();
                    System.out.println("Книга " + nameBook + " автор " + aothe + "  добавлен в библиотеку");
                    try {
                        FileOutputStream outputStream = new FileOutputStream("lidery");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                        objectOutputStream.writeObject(lidraries);

                        outputStream.close();


                    } catch (IOException e) {

                    }
                    while (true) {
                        System.out.println("-------------------------------------");
                        System.out.println("Вы хотите ище добавить книгу? 1 - Да");
                        System.out.println("Вернутся в главный меню? 2 - Да");
                        try {
                            int answer1 = Integer.parseInt(reader.readLine());
                            if (answer1 == 1) {
                                break;
                            } else if (answer1 == 2) {
                                outh();
                            } else {
                                System.out.println("Введите цыфру где указына");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");
                        }
                    }
                } else if (answer == 2) {
                    outh();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }
    }

    //6: Меню регистраций
    public static void infoBooks() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("Вы студент? 1 - Да");
            System.out.println("Вы учитель? 2 - Да");
            System.out.println("Вернутся в главный меню? 3 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                switch (answer) {
                    case 1:
                        AddStudent();
                        break;
                    case 2:
                        AddTeacher();
                        break;
                    case 3:
                        outh();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }
    }

    // зарегристриревоться ученика
    public static void AddStudent() throws IOException {
        while (true) {
            System.out.println("Здравствуйте");
            System.out.println("Вы правда хотите зарегристриревоться ? 1 - Да");
            System.out.println("Вернутся в главный меню? 2 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer == 1) {
                    System.out.println("Введите имя");
                    String name = reader.readLine();
                    System.out.println("Введите логин");
                    String login = reader.readLine();
                    System.out.println("Введите пароль");
                    String possword = reader.readLine();
                    peopleReader.add(new Student(generetyID(), name, login, possword));
                    System.out.println();
                    System.out.println("Вы успешно зарегристриреволисься");
                    System.out.println("типер у вас есть свой личный кабинет");
                    try {
                        FileOutputStream outputStream = new FileOutputStream("people");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                        objectOutputStream.writeObject(peopleReader);

                    } catch (IOException e) {

                    }
                    while (true) {
                        System.out.println();
                        System.out.println("Ише кто хочет зарегристриреваться? 1 - Да");
                        System.out.println("Вернутся в главный меню? 2 - Да");
                        System.out.println("Хотите попасть свой кабинет авторизуйтесь? 3 - Да");
                        try {
                            int big = Integer.parseInt(reader.readLine());
                            if (big == 1) {
                                break;
                            } else if (big == 2) {
                                outh();
                            } else if (big == 3) {
                                AuthorizationReader();
                            } else {
                                System.out.println("Введите цыфру где указына");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");
                        }
                    }
                } else if (answer == 2) {
                    outh();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }
    }

    // зарегристриревоться учитель
    public static void AddTeacher() throws IOException {
        boolean hoco = false;
        while (true) {
            System.out.println("Здравствуйте");
            System.out.println("Вы правда хотите зарегристриревоться ? 1 - Да");
            System.out.println("Вернутся в главный меню? 2 - Да");
            int answer = Integer.parseInt(reader.readLine());
            try {
                if (answer == 1) {
                    System.out.println("Введите имя");
                    String name = reader.readLine();
                    System.out.println("Введите логин");
                    String login = reader.readLine();
                    System.out.println("Введите пароль");
                    String possword = reader.readLine();
                    peopleReader.add(new Teacher(generetyID(), name, login, possword));
                    System.out.println();
                    System.out.println("Вы успешно зарегристриреволисься");
                    try {
                        FileOutputStream inputStream = new FileOutputStream("people");
                        ObjectOutputStream objectInputStream = new ObjectOutputStream(inputStream);

                        objectInputStream.writeObject(peopleReader);

                        objectInputStream.close();
                    } catch (NullPointerException e) {

                    }
                    while (true) {
                        System.out.println();
                        System.out.println("Вы хотите зарегристриревать? 1 - Да");
                        System.out.println("Вернутся в главный меню? 2 - Да");
                        System.out.println("Хотите попасть свой кабинет? 3 - Да");
                        try {
                            int big = Integer.parseInt(reader.readLine());
                            if (big == 1) {
                                break;
                            } else if (big == 2) {
                                outh();
                            } else if (big == 3) {

                            } else {
                                System.out.println("Введите цыфру где указына");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");
                        }
                    }
                } else if (answer == 2) {
                    outh();
                }

            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }
    }


    //7:  Меню автаризаций
    public static void AuthorizationReader() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("Вы студент? 1 - Да");
            System.out.println("Вы учитель? 2 - Да");
            System.out.println("Вернутся в главный меню? 3 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                switch (answer) {
                    case 1:
                        AuthorizationStudent();
                        break;
                    case 2:
                        AuthorizationTeacher();
                        break;
                    case 3:
                        outh();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }
    }

    //Авторизует студент
    public static void AuthorizationStudent() throws IOException {
        System.out.println();
        System.out.println("Здравствуйте");
        System.out.println("Введите логин");
        String login = reader.readLine();
        System.out.println("Введите пароль");
        String possword = reader.readLine();
        boolean write = false;
        for (Reader reader1 : peopleReader) {
            if (reader1 instanceof Student) {
                Student student = (Student) reader1;
                if (login.equals(student.getLogin()) && possword.equals(student.getPassword())) {
                    write = true;
                    System.out.println("---------------------------");
                    System.out.println("Здравствуте " + student.getName());
                    System.out.println("Вы вошли свой личный кабинет");
                    System.out.println("---------------------------");
                    System.out.println("Что вы хотите сделать");
                    while (true) {
                        System.out.println("---------------------");
                        System.out.println("1. Взять книгу");
                        System.out.println("2. Вернуть книгу");
                        System.out.println("Вернутся в главный меню? 3 - Да");
                        try {
                            int answer = Integer.parseInt(reader.readLine());
                            if (answer == 1) {
                                AddBookStudent(login,possword);

                            } else if (answer == 2) {
                                returnBookStudent(login, possword);

                            } else if (answer == 3) {
                                outh();
                            } else {
                                System.out.println("Введите цыфру где указына");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");
                            System.out.println();
                        }
                    }
                }
            }
        }
        if (!write) {
            System.out.println("Неправильный логин и пароль!");
        }

        while (true) {
            System.out.println("-----------------");
            System.out.println("Вернутся в главный меню? 1 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer == 1) {
                    outh();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }

    }

    public static void AuthorizationTeacher() throws IOException {
        System.out.println();
        System.out.println("Здравствуйте");
        System.out.println("Введите логин");
        String login = reader.readLine();
        System.out.println("Введите пароль");
        String possword = reader.readLine();
        boolean write = false;
        for (Reader reader1 : peopleReader) {
            if (reader1 instanceof Teacher) {
                Teacher teacher = (Teacher) reader1;
                if (login.equals(teacher.getLogin()) && possword.equals(teacher.getPassword())) {
                    write = true;
                    System.out.println("---------------------------");
                    System.out.println("Здравствуте " + teacher.getName());
                    System.out.println("Вы вошли свой личный кабинет");
                    System.out.println("---------------------------");
                    System.out.println("Что вы хотите сделать");
                    while (true) {
                        System.out.println("---------------------");
                        System.out.println("1. Взять книгу");
                        System.out.println("2. Вернуть книгу");
                        System.out.println("Вернутся в главный меню? 3 - Да");
                        try {
                            int answer = Integer.parseInt(reader.readLine());
                            if (answer == 1) {
                                AddBookTeacher(login,possword);

                            } else if (answer == 2) {
                                returnBookTeacher(login,possword);

                            } else if (answer == 3) {
                                outh();
                            } else {
                                System.out.println("Введите цыфру где указына");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");
                            System.out.println();
                        }
                    }
                }
            }
        }
        if (!write) {
            System.out.println("Неправильный логин и пароль!");
        }
        while (true) {
            System.out.println("-----------------");
            System.out.println("Вернутся в главный меню? 1 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer == 1) {
                    outh();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }
    }

    //Студент берет книгу
    public static void AddBookStudent(String name, String possword) throws IOException {
        ArrayList<Books> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        String st = "";
        int count = 0;
        int temp = 0;
        for (Reader readerStudent : peopleReader) {
            if (readerStudent instanceof Student) {
                Student student = (Student) readerStudent;
                if (name.equals(student.getLogin()) && possword.equals(student.getPassword())) {
                    System.out.println();
                    System.out.println("Какую книгу хотите взять?");
                    String nameBook = reader.readLine();
                    boolean answerBook = false;
                    System.out.println("-----------------");
                    for (Books books : lidraries) {
                        if (count == 0) {
                            for (int i = 0; i < nameBook.length(); i++) {
                                if (i == 0) {
                                    st = String.valueOf(nameBook.charAt(i));
                                    builder.append(st.toUpperCase());
                                } else {
                                    builder.append(String.valueOf(nameBook.charAt(i)));
                                }
                            }
                        }
                        count++;
                        if (books.isInStock()) {
                            if (books.getName().matches("(.*)" + builder + "(.*)") || books.getAuthor().matches("(.*)" + builder + "(.*)")) {
                                System.out.println("№" + count + ". " + books.getName() + " автор книги " + books.getAuthor());
                                answerBook = true;
                                temp = count;
                                list.add(books);
                            } else if (books.getName().matches("(.*)" + nameBook + "(.*)") || books.getAuthor().matches("(.*)" + nameBook + "(.*)")) {
                                System.out.println("№" + count + ". " + books.getName() + " автор книги " + books.getAuthor());
                                answerBook = true;
                                temp = count;
                                list.add(books);
                            }
                        }
                    }
                    if (!answerBook) {
                        System.out.println("Книга не найдено");
                        break;
                    }

                    while (true) {
                        System.out.println("------------------------------------------");
                        System.out.println("Хотите взять книгу то напишите номер книги");
                        try {
                            int answer = Integer.parseInt(reader.readLine());
                            count = 0;
                            String lust = "";
                            for (Books books : lidraries) {
                                count++;
                                if (answer == count) {
                                    lust = books.getName();
                                    for (int i = 0; i < list.size(); i++) {
                                        if (lust.equals(list.get(i).getName())) {
                                            if (temp >= count) {
                                                if (books.isInStock()) {
                                                    System.out.println("-----------------");
                                                    System.out.println("Вы правда хотите взять книгу? 1 - Да");
                                                    System.out.println("Вернутся в главный меню? 2 - Да");
                                                    int big = Integer.parseInt(reader.readLine());
                                                    if (big == 1) {
                                                        books.setUser(student);
                                                        books.setInStock(false);
                                                        student.AddissueBook(books);
                                                        System.out.println(student.getName() + " поздравляю вы взяли книгу " + books.getName());
                                                        try {
                                                            FileOutputStream outputStream = new FileOutputStream("lidery");
                                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                                            objectOutputStream.writeObject(lidraries);

                                                        } catch (Exception e) {

                                                        }
                                                        while (true) {
                                                            System.out.println("-------------------");
                                                            System.out.println("Вернутся в главный меню? 1 - Да");
                                                            try {
                                                                int answer1 = Integer.parseInt(reader.readLine());
                                                                if (answer1 == 1) {
                                                                    outh();
                                                                } else {
                                                                    System.out.println();
                                                                    System.out.println("Вы ввели не ту цыфру");
                                                                    System.out.println("Введите то что показына");
                                                                }
                                                            } catch (NumberFormatException e) {
                                                                System.out.println();
                                                                System.out.println("Вы ввели не цывру");
                                                                System.out.println("Введите цыфру");
                                                            }
                                                        }
                                                    } else if (big == 2) {
                                                        outh();
                                                    } else {
                                                        System.out.println();
                                                        System.out.println("Вы ввели не ту цыфру");
                                                        System.out.println("Введите то что показына");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");

                        }
                    }

                }
            }
        }

        while (true) {
            System.out.println("-------------------");
            System.out.println("Вернутся в главный меню? 1 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer == 1) {
                    outh();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }

    }

    //студенит возврашають книгу
    public static void returnBookStudent(String name, String possword) throws IOException {
        ArrayList<Books> list = new ArrayList<>();
        ArrayList<String> comentary = new ArrayList<>();
        int count = 0;
        int temp = 0;
        for (Reader readerPeople : peopleReader) {
            if (readerPeople instanceof Student) {
                Student student = (Student) readerPeople;
                if (name.equals(student.getLogin()) && possword.equals(student.getPassword())) {
                    boolean answerStudent = false;
                    System.out.println("здравствуйте " + student.getName());
                    for (Books books : lidraries) {
                        count++;
                        if (!books.isInStock()) {
                            if (books.getUser().getName().equals(student.getName())) {
                                System.out.println("У вас есть книги №" + count + ". " + books.getName());
                                answerStudent = true;
                                temp = count;
                                list.add(books);
                            }
                        }
                    }
                    if (!answerStudent) {
                        while (true) {
                            System.out.println("-------------------");
                            System.out.println("У вас нету книг");
                            System.out.println("Вернутся в главный меню? 1 - Да");
                            System.out.println("Хотите взять книгу автаризуйтесь? 2 - Да");
                            try {
                                int answer = Integer.parseInt(reader.readLine());
                                if (answer == 1) {
                                    outh();
                                } else if (answer == 2) {
                                    AuthorizationReader();
                                } else {
                                    System.out.println("Введите пожалуста цыфру где показына");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println();
                                System.out.println("Вы ввели не цывру");
                                System.out.println("Введите цыфру");
                            }
                        }
                    }
                    while (true) {
                        try {
                            System.out.println();
                            System.out.println("Введите номер книги");
                            int answer1 = Integer.parseInt(reader.readLine());
                            count = 0;
                            String lust = "";
                            for (Books books : lidraries) {
                                count++;
                                if (answer1 == count) {
                                    lust = books.getName();
                                    for (int i = 0; i < list.size(); i++) {
                                        if (lust.equals(list.get(i).getName())){
                                            if (temp >= count) {
                                                while (true) {
                                                    System.out.println();
                                                    System.out.println("Вы правда хотите вернуть книгу? 1 - Да ");
                                                    System.out.println("Вернутся в главный меню? 2 - Да");
                                                    try {
                                                        int big = Integer.parseInt(reader.readLine());
                                                        if (big == 1) {
                                                            System.out.println();
                                                            System.out.println("Вы успешно передали книгу");
                                                            System.out.println("Спосибо что выбирайите нас!");
                                                            System.out.println("---------------------------");
                                                            books.setInStock(true);
                                                            while (true) {
                                                                System.out.println();
                                                                System.out.println("Книга понравился? 1 - Да");
                                                                System.out.println("Книга не понравился? 2 - Да");
                                                                System.out.println("Хотите оставить свой коментарий? 3 - Да");
                                                                System.out.println("Вернутся в главный меню? 4 - Да");
                                                                System.out.println("--------------------------------");
                                                                try {
                                                                    int com = Integer.parseInt(reader.readLine());
                                                                    if (com == 1) {
                                                                        books.setLike(1);
                                                                        System.out.println("Спосибо за лайк (:");
                                                                        while (true) {
                                                                            System.out.println("Хотите оставить свой коментарий? 1 - Да");
                                                                            System.out.println("без коментариев? 2 - Да");
                                                                            try {
                                                                                int mak = Integer.parseInt(reader.readLine());
                                                                                if (mak == 1) {
                                                                                    System.out.println("Напишите коментарий");
                                                                                    String comentory = reader.readLine();
                                                                                    comentary.add(comentory);
                                                                                    books.setComent(comentary);
                                                                                    System.out.println("Спосибо за коментарию");
                                                                                    break;
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                System.out.println("Вы не ту цыфру нажали");
                                                                            }
                                                                        }
                                                                        try {
                                                                            FileOutputStream outputStream = new FileOutputStream("lidery");
                                                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                                                            objectOutputStream.writeObject(lidraries);

                                                                        } catch (Exception e) {

                                                                        }

                                                                        while (true) {
                                                                            System.out.println("-------------------");
                                                                            System.out.println("Вернутся в главный меню? 1 - Да");
                                                                            try {
                                                                                int answer2 = Integer.parseInt(reader.readLine());
                                                                                if (answer2 == 1) {
                                                                                    outh();
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                System.out.println();
                                                                                System.out.println("Вы ввели не цывру");
                                                                                System.out.println("Введите цыфру!");
                                                                            }
                                                                        }
                                                                    } else if (com == 2) {
                                                                        System.out.println("Спосибо за замичание");
                                                                        System.out.println("Следующий раз будет лучшые книги :)");
                                                                        books.setDontLike(1);
                                                                        try {
                                                                            FileOutputStream outputStream = new FileOutputStream("lidery");
                                                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                                                            objectOutputStream.writeObject(lidraries);

                                                                        } catch (Exception e) {

                                                                        }

                                                                        while (true) {
                                                                            System.out.println("-------------------");
                                                                            System.out.println("Вернутся в главный меню? 1 - Да");
                                                                            try {
                                                                                int answer2 = Integer.parseInt(reader.readLine());
                                                                                if (answer2 == 1) {
                                                                                    outh();
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                System.out.println();
                                                                                System.out.println("Вы ввели не цывру");
                                                                                System.out.println("Введите цыфру!");
                                                                            }
                                                                        }
                                                                    } else if (com == 3) {
                                                                        System.out.println("Напишите коментарий");
                                                                        String comentory = reader.readLine();
                                                                        comentary.add(comentory);
                                                                        books.setComent(comentary);
                                                                        System.out.println("Спосибо за коментарию");
                                                                        while (true) {
                                                                            System.out.println("книга понравился? 1 - Да");
                                                                            System.out.println("без лайков? 2 - Да");
                                                                            try {
                                                                                int mak = Integer.parseInt(reader.readLine());
                                                                                if (mak == 1) {
                                                                                    books.setLike(1);
                                                                                    System.out.println("Спосибо за лайк (:");
                                                                                    break;
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                System.out.println("Вы не ту цыфру нажали");
                                                                            }
                                                                        }
                                                                        try {
                                                                            FileOutputStream outputStream = new FileOutputStream("lidery");
                                                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                                                            objectOutputStream.writeObject(lidraries);

                                                                        } catch (Exception e) {

                                                                        }
                                                                        while (true) {
                                                                            System.out.println("-------------------");
                                                                            System.out.println("Вернутся в главный меню? 1 - Да");
                                                                            try {
                                                                                int answer2 = Integer.parseInt(reader.readLine());
                                                                                if (answer2 == 1) {
                                                                                    outh();
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                System.out.println();
                                                                                System.out.println("Вы ввели не цывру");
                                                                                System.out.println("Введите цыфру");
                                                                            }
                                                                        }
                                                                    }
                                                                    if (com == 4) {
                                                                        try {
                                                                            FileOutputStream outputStream = new FileOutputStream("lidery");
                                                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                                                            objectOutputStream.writeObject(lidraries);

                                                                        } catch (Exception e) {

                                                                        }
                                                                        outh();
                                                                    } else {
                                                                        System.out.println("Введите цыфру где укзына");
                                                                    }
                                                                } catch (NumberFormatException e) {
                                                                    System.out.println("Вы ввели ни ту цыфру");
                                                                    System.out.println("Введите снова ");
                                                                }
                                                            }
                                                        } else if (big == 2) {
                                                            outh();
                                                        } else {
                                                            System.out.println("Введите цыфру где укзына");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println();
                                                        System.out.println("Вы ввели не цывру");
                                                        System.out.println("Введите цыфру");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");
                        }
                    }
                }
            }
        }

        while (true) {
            System.out.println("-------------------");
            System.out.println("Вернутся в главный меню? 1 - Да");
            try {
                int answer1 = Integer.parseInt(reader.readLine());
                if (answer1 == 1) {
                    outh();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }
    }


    //Учитель берет книгу
    public static void AddBookTeacher(String name, String possword) throws IOException {
        StringBuilder builder = new StringBuilder();
        ArrayList<Books> list = new ArrayList<>();
        String st = "";
        int count = 0;
        int temp = 0;
        for (Reader readerTeacher : peopleReader) {
            if (readerTeacher instanceof Teacher) {
                Teacher teacher = (Teacher) readerTeacher;
                if (name.equals(teacher.getLogin()) && possword.equals(teacher.getPassword())) {
                    System.out.println();
                    System.out.println("Какую книгу хотите взять?");
                    String nameBook = reader.readLine();
                    boolean answerBook = false;
                    System.out.println("-----------------");
                    for (Books books : lidraries) {
                        if (count == 0) {
                            for (int i = 0; i < nameBook.length(); i++) {
                                if (i == 0) {
                                    st = String.valueOf(nameBook.charAt(i));
                                    builder.append(st.toUpperCase());
                                } else {
                                    builder.append(String.valueOf(nameBook.charAt(i)));
                                }
                            }
                        }
                        count++;
                        if (books.isInStock()) {
                            if (books.getName().matches("(.*)" + builder + "(.*)") || books.getAuthor().matches("(.*)" + builder + "(.*)")) {
                                System.out.println("№" + count + ". " + books.getName() + " автор книги " + books.getAuthor());
                                answerBook = true;
                                temp = count;
                                list.add(books);
                            } else if (books.getName().matches("(.*)" + nameBook + "(.*)") || books.getAuthor().matches("(.*)" + nameBook + "(.*)")) {
                                System.out.println("№" + count + ". " + books.getName() + " автор книги " + books.getAuthor());
                                answerBook = true;
                                temp = count;
                                list.add(books);
                            }
                        }
                    }
                    if (!answerBook) {
                        System.out.println("Ваша книга не найдена");
                        break;
                    }
                    while (true) {
                        System.out.println("------------------------------------------");
                        System.out.println("Хотите взять книгу то напишите номер книги");
                        try {
                            int answer = Integer.parseInt(reader.readLine());
                            count = 0;
                            String lust = "";
                            for (Books books : lidraries) {
                                count++;
                                if (answer == count) {
                                    lust = books.getName();
                                    for (int i = 0; i < list.size(); i++) {
                                        if (lust.equals(list.get(i).getName())) {
                                            if (temp >= count) {
                                                if (books.isInStock()) {
                                                    System.out.println("-----------------");
                                                    System.out.println("Вы правда хотите взять книгу? 1 - Да");
                                                    System.out.println("Вернутся в главный меню? 2 - Да");
                                                    int big = Integer.parseInt(reader.readLine());
                                                    if (big == 1) {
                                                        books.setUser(teacher);
                                                        books.setInStock(false);
                                                        teacher.AddissueBook(books);
                                                        System.out.println(teacher.getName() + " поздравляю вы взяли книгу " + books.getName());
                                                        try {
                                                            FileOutputStream outputStream = new FileOutputStream("lidery");
                                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                                            objectOutputStream.writeObject(lidraries);

                                                        } catch (Exception e) {

                                                        }
                                                        while (true) {
                                                            System.out.println("-------------------");
                                                            System.out.println("Вернутся в главный меню? 1 - Да");
                                                            try {
                                                                int answer1 = Integer.parseInt(reader.readLine());
                                                                if (answer1 == 1) {
                                                                    outh();
                                                                } else {
                                                                    System.out.println();
                                                                    System.out.println("Вы ввели не ту цыфру");
                                                                    System.out.println("Введите то что показына");
                                                                }
                                                            } catch (NumberFormatException e) {
                                                                System.out.println();
                                                                System.out.println("Вы ввели не цывру");
                                                                System.out.println("Введите цыфру");
                                                            }
                                                        }
                                                    } else if (big == 2) {
                                                        outh();
                                                    } else {
                                                        System.out.println();
                                                        System.out.println("Вы ввели не ту цыфру");
                                                        System.out.println("Введите то что показына");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");

                        }
                    }
                }
            }
        }

        while (true) {
            System.out.println("-------------------");
            System.out.println("Вернутся в главный меню? 1 - Да");
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer == 1) {
                    outh();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }
    }

    //учитель возврашають книгу
    public static void returnBookTeacher(String name, String possword) throws IOException {
        int count = 0;
        int temp = 0;
        ArrayList<String> comentary = new ArrayList<>();
        ArrayList<Books> list = new ArrayList<>();
        for (Reader readerPeople : peopleReader) {
            if (readerPeople instanceof Teacher) {
                Teacher teacher = (Teacher) readerPeople;
                if (name.equals(teacher.getLogin()) && possword.equals(teacher.getPassword())) {
                    boolean answerStudent = false;
                    for (Books books : lidraries) {
                        count++;
                        if (!books.isInStock()) {
                            if (books.getUser().getName().equals(teacher.getName())) {
                                System.out.println("У вас есть книги №" + count + ". " + books.getName());
                                list.add(books);
                                temp = count;
                                answerStudent = true;
                            }
                        }
                    }

                    if (!answerStudent) {
                        while (true) {
                            System.out.println("-------------------");
                            System.out.println("У вас нету книг");
                            System.out.println("Вернутся в главный меню? 1 - Да");
                            System.out.println("Хотите взять книгу автаризуйтесь? 2 - Да");
                            try {
                                int answer = Integer.parseInt(reader.readLine());
                                if (answer == 1) {
                                    outh();
                                } else if (answer == 2) {
                                    AuthorizationReader();
                                } else {
                                    System.out.println("Введите пожалуста цыфру где показына");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println();
                                System.out.println("Вы ввели не цывру");
                                System.out.println("Введите цыфру");
                            }
                        }
                    }
                    while (true) {
                        System.out.println();
                        System.out.println("Введите номер книги");
                        try {
                            int answer1 = Integer.parseInt(reader.readLine());
                            count = 0;
                            String lust = "";
                            for (Books books : lidraries) {
                                count++;
                                if (answer1 == count) {
                                    lust = books.getName();
                                    for (int i = 0; i < list.size(); i++) {
                                        if (lust.equals(list.get(i).getName())) {
                                            if (temp >= count) {
                                                while (true) {
                                                    System.out.println();
                                                    System.out.println("Вы правда хотите вернуть книгу? 1 - Да ");
                                                    System.out.println("Вернутся в главный меню? 2 - Да");
                                                    try {
                                                        int big = Integer.parseInt(reader.readLine());
                                                        if (big == 1) {
                                                            System.out.println();
                                                            System.out.println("Вы успешно передали книгу");
                                                            System.out.println("Спосибо что выбирайите нас!");
                                                            System.out.println("---------------------------");
                                                            books.setInStock(true);
                                                            while (true) {
                                                                System.out.println();
                                                                System.out.println("Книга понравился? 1 - Да");
                                                                System.out.println("Книга не понравился? 2 - Да");
                                                                System.out.println("Хотите оставить свой коментарий? 3 - Да");
                                                                System.out.println("Вернутся в главный меню? 4 - Да");
                                                                System.out.println("--------------------------------");
                                                                try {
                                                                    int com = Integer.parseInt(reader.readLine());
                                                                    if (com == 1) {
                                                                        books.setLike(1);
                                                                        System.out.println("Спосибо за лайк (:");
                                                                        while (true) {
                                                                            System.out.println("Хотите оставить свой коментарий? 1 - Да");
                                                                            System.out.println("без коментариев? 2 - Да");
                                                                            try {
                                                                                int mak = Integer.parseInt(reader.readLine());
                                                                                if (mak == 1) {
                                                                                    System.out.println("Напишите коментарий");
                                                                                    String comentory = reader.readLine();
                                                                                    comentary.add(comentory);
                                                                                    books.setComent(comentary);
                                                                                    System.out.println("Спосибо за коментарию");
                                                                                    break;
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                System.out.println("Вы не ту цыфру нажали");
                                                                            }
                                                                        }
                                                                        try {
                                                                            FileOutputStream outputStream = new FileOutputStream("lidery");
                                                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                                                            objectOutputStream.writeObject(lidraries);

                                                                        } catch (Exception e) {

                                                                        }
                                                                        while (true) {
                                                                            System.out.println("-------------------");
                                                                            System.out.println("Вернутся в главный меню? 1 - Да");
                                                                            try {
                                                                                int answer2 = Integer.parseInt(reader.readLine());
                                                                                if (answer2 == 1) {
                                                                                    outh();
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                System.out.println();
                                                                                System.out.println("Вы ввели не цывру");
                                                                                System.out.println("Введите цыфру");
                                                                            }
                                                                        }
                                                                    } else if (com == 2) {
                                                                        System.out.println("Спосибо за замичание");
                                                                        System.out.println("Следующий раз будет лучшые книги :)");
                                                                        books.setDontLike(1);
                                                                        try {
                                                                            FileOutputStream outputStream = new FileOutputStream("lidery");
                                                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                                                            objectOutputStream.writeObject(lidraries);

                                                                        } catch (Exception e) {

                                                                        }

                                                                        while (true) {
                                                                            System.out.println("-------------------");
                                                                            System.out.println("Вернутся в главный меню? 1 - Да");
                                                                            try {
                                                                                int answer2 = Integer.parseInt(reader.readLine());
                                                                                if (answer2 == 1) {
                                                                                    outh();
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                System.out.println();
                                                                                System.out.println("Вы ввели не цывру");
                                                                                System.out.println("Введите цыфру!");
                                                                            }
                                                                        }
                                                                    } else if (com == 3) {
                                                                        System.out.println("Напишите коментарий");
                                                                        String comentory = reader.readLine();
                                                                        comentary.add(comentory);
                                                                        books.setComent(comentary);
                                                                        System.out.println("Спосибо за коментарию");

                                                                        while (true) {
                                                                            System.out.println("книга понравился? 1 - Да");
                                                                            System.out.println("без лайков? 2 - Да");
                                                                            try {
                                                                                int mak = Integer.parseInt(reader.readLine());
                                                                                if (mak == 1) {
                                                                                    books.setLike(1);
                                                                                    System.out.println("Спосибо за лайк (:");
                                                                                    break;
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                System.out.println("Вы не ту цыфру нажали");
                                                                            }
                                                                        }
                                                                        try {
                                                                            FileOutputStream outputStream = new FileOutputStream("lidery");
                                                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                                                            objectOutputStream.writeObject(lidraries);

                                                                        } catch (Exception e) {

                                                                        }
                                                                        while (true) {
                                                                            System.out.println("-------------------");
                                                                            System.out.println("Вернутся в главный меню? 1 - Да");
                                                                            try {
                                                                                int answer2 = Integer.parseInt(reader.readLine());
                                                                                if (answer2 == 1) {
                                                                                    outh();
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                System.out.println();
                                                                                System.out.println("Вы ввели не цывру");
                                                                                System.out.println("Введите цыфру");
                                                                            }
                                                                        }
                                                                    }
                                                                    if (com == 4) {
                                                                        try {
                                                                            FileOutputStream outputStream = new FileOutputStream("lidery");
                                                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                                                                            objectOutputStream.writeObject(lidraries);

                                                                        } catch (Exception e) {

                                                                        }
                                                                        outh();
                                                                    } else {
                                                                        System.out.println("Введите цыфру где укзына");
                                                                    }
                                                                } catch (NumberFormatException e) {
                                                                    System.out.println("Вы ввели ни ту цыфру");
                                                                    System.out.println("Введите снова ");
                                                                }
                                                            }
                                                        } else if (big == 2) {
                                                            outh();
                                                        } else {
                                                            System.out.println("Введите цыфру где укзына");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println();
                                                        System.out.println("Вы ввели не цывру");
                                                        System.out.println("Введите цыфру");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Вы ввели не цывру");
                            System.out.println("Введите цыфру");
                        }
                    }
                }
            }
        }
        while (true) {
            System.out.println("-------------------");
            System.out.println("Вернутся в главный меню? 1 - Да");
            try {
                int answer1 = Integer.parseInt(reader.readLine());
                if (answer1 == 1) {
                    outh();
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Вы ввели не цывру");
                System.out.println("Введите цыфру");
            }
        }
    }


    //Генерация индивидуального ID
    public static int generetyID() {
        int id = (int) (Math.random() * 899) + 100;

        boolean answer = checkID(id);
        if (answer) {
            return id;
        } else {
            return generetyID();
        }

    }


    //Проверка индивидуального ID
    public static boolean checkID(int id) {
        for (Books employee : listBook) {
            if (id == employee.getId()) {
                return false;
            }
        }
        return true;
    }

}
