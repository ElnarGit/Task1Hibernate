package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            //С помощью Hibernate получите любого режиссера, а затем получите список его фильмов

           /* Director director = session.get(Director.class, 2);
            System.out.println(director);

            List<Movie> movies = director.getMovies();

            for(Movie movie : movies)
                System.out.println(movie);*/


            //Получите любой фильм, а затем получите его режиссера.
           /* Movie movie = session.get(Movie.class, 5);
            Director director = movie.getDirector();
            System.out.println(director);*/


            //Добавьте еще один фильм для любого режиссера.

          /*  Director director = session.get(Director.class,5);
            Movie movie = new Movie("Hello world", 2023, director);

            director.getMovies().add(movie);

           session.save(movie);*/

            //Создайте нового режиссера и новый фильм и свяжите эти сущности.

            /*Director director = new Director("Era Dochanov",23);

            Movie movie = new Movie("Hello Python", 2022, director);

            director.setMovies(new ArrayList<>(Collections.singletonList(movie)));

            session.save(director);

            session.save(movie);*/

            //Смените режиссера у существующего фильма.

           /* Movie movie = session.get(Movie.class,10);
            Director director = session.get(Director.class,7);

            movie.getDirector().getMovies().remove(movie);

            movie.setDirector(director);
            director.getMovies().add(movie);*/


            //Удалите фильм у любого режиссера.

           /* Movie movie = session.get(Movie.class,1);
            session.delete(movie);*/



            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}