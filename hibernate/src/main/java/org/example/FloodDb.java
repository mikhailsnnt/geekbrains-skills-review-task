package org.example;

import java.util.Random;
import java.util.stream.Stream;

public class FloodDb {

    public static void main(String[] args) {
        new FloodDb().generateRows(1000);
    }

    private final StudentRepository studentRepository;

    public FloodDb() {
        studentRepository = new StudentRepository(HibernateUtil.getSessionFactory());
    }

    private void generateRows(int number){
        Random random = new Random();
        Stream.generate(()-> new Student(randomString(random),randomMark(random)))
                .limit(number)
                .forEach(studentRepository::save);
    }

    private  String randomString(Random random){
        int len = random.nextInt(10);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++)
            stringBuilder.append((char) random.nextInt('a','z'+1));
        return stringBuilder.toString();
    }

    private  int randomMark(Random random){
        return random.nextInt(1,6);
    }
}
