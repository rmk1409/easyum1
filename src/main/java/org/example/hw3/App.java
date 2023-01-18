package org.example.hw3;

import org.example.hw3.model.Answer;
import org.example.hw3.model.Level;
import org.example.hw3.model.Question;
import org.example.hw3.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Level.class)
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Topic.class)
                .buildSessionFactory()
        ) {

            // добавить записи
            fillDB(factory);

            // получить вопрос с ответами по профилю и уровню
            System.out.println(getQuestionWithAnswersByTopicAndByLevel("JAVA", "easy", factory));
            System.out.println(getQuestionWithAnswersByTopicAndByLevel("DB", "easy", factory));

            // сделать update
            System.out.println(getQuestionWithAnswersByTopicAndByLevel("DB", "easy", factory));
            update(factory);
            System.out.println(getQuestionWithAnswersByTopicAndByLevel("DB", "easy", factory));

            // сделать delete
            System.out.println(getQuestionWithAnswersByTopicAndByLevel("DB", "easy", factory));
            delete(factory);
            System.out.println(getQuestionWithAnswersByTopicAndByLevel("DB", "easy", factory));
        }
    }

    private static void fillDB(SessionFactory factory) {
        addLevels(factory);
        addTopics(factory);
        addQuestions(factory);
        addAnswers(factory);
    }

    private static void addLevels(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(new Level("easy"));
            session.save(new Level("medium"));
            session.save(new Level("hard"));
            session.getTransaction().commit();
        }
    }

    private static void addTopics(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(new Topic("JAVA"));
            session.save(new Topic("DB"));
            session.getTransaction().commit();
        }
    }

    private static void addQuestions(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Question question1 = new Question("question1");
            question1.setLevel(session.get(Level.class, 1));
            question1.setTopic(session.get(Topic.class, 1));
            session.save(question1);

            Question question2 = new Question("question2");
            question2.setLevel(session.get(Level.class, 1));
            question2.setTopic(session.get(Topic.class, 2));
            session.save(question2);

            Question question3 = new Question("question3");
            question3.setLevel(session.get(Level.class, 2));
            question3.setTopic(session.get(Topic.class, 2));
            session.save(question3);

            session.getTransaction().commit();
        }
    }

    private static void addAnswers(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Question question1 = session.get(Question.class, 1);
            Answer answer1 = new Answer("answer1");
            Answer answer2 = new Answer("answer2");
            session.save(answer1);
            session.save(answer2);

            question1.addAnswer(answer1);
            question1.addAnswer(answer2);
            session.save(question1);

            Question question2 = session.get(Question.class, 2);
            Answer answer3 = new Answer("answer3");
            Answer answer4 = new Answer("answer4");
            Answer answer5 = new Answer("answer5");
            session.save(answer3);
            session.save(answer4);
            session.save(answer5);

            question2.addAnswer(answer3);
            question2.addAnswer(answer4);
            question2.addAnswer(answer5);
            session.save(question2);

            session.getTransaction().commit();
        }
    }

    private static List<Question> getQuestionWithAnswersByTopicAndByLevel(String topic, String level, SessionFactory factory) {
        List<Question> questions;

        try (Session session = factory.openSession()) {
            Topic topic1 = session.createQuery(
                    "FROM Topic t WHERE t.name = '" + topic + "'", Topic.class
            ).getSingleResult();
            Level level1 = session.createQuery(
                    "FROM Level l WHERE l.name = '" + level + "'", Level.class
            ).getSingleResult();
            Query<Question> query = session.createQuery(
                    "FROM Question q LEFT JOIN FETCH q.answers WHERE q.topic = :topic AND q.level = :level", Question.class
            );
            query.setParameter("topic", topic1);
            query.setParameter("level", level1);
            questions = query.getResultList();
        }

        return questions;
    }

    private static void update(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Question question2 = session.get(Question.class, 2);
            Answer answer3 = session.get(Answer.class, 3);
            Answer answer4 = session.get(Answer.class, 4);
            question2.removeAnswer(answer3);
            question2.removeAnswer(answer4);

            session.getTransaction().commit();
        }
    }

    private static void delete(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Question question = session.get(Question.class, 2);
            session.remove(question);

            session.getTransaction().commit();
        }
    }
}
