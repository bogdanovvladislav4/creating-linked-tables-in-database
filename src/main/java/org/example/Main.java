package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Subscription subscription = session.get(Subscription.class, new SubscriptionKey(94, 13));

        Course course = session.get(Course.class, 2);

        System.out.println(subscription.getCourse().getId() + " - " + subscription.getStudent().getId()
                + " - " + subscription.getSubscriptionDate());
        System.out.println(subscription.getCourse().getName() + " - " + subscription.getStudent().getName()
                + " - " + subscription.getSubscriptionDate());
        System.out.println(course.getName() + " - " + course.getTeacher().getName()
                + " - " + course.getTeacher().getSalary());

        sessionFactory.close();
    }
}