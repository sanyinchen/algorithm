package leet_code.weekly_contest.biweekly_contest_12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Design_a_leaderboard_5097 {

    class Leaderboard {

        private PriorityQueue<Person> scoreList;

        public Leaderboard() {
            scoreList = new PriorityQueue<>(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o2.score - o1.score;
                }
            });

        }

        public void addScore(int playerId, int score) {
            System.out.println("playerId:" + playerId + " score:" + score);
            Person person = null;
            Iterator<Person> iterable = scoreList.iterator();
            int i = 0;
            while (iterable.hasNext()) {
                i++;
                Person temp = iterable.next();
                if (temp.id == playerId) {
                    person = temp;
                    break;
                }
            }
            if (person == null) {
                person = new Person(playerId, score);
                scoreList.add(person);
                System.out.println(scoreList.size() + " new : " + playerId + " i:" + i);
            } else {

                System.out.println(scoreList.size() + " change : " + playerId + " old:" + person.score + " => " + score);
                person.score += score;

            }

        }

        public int top(int k) {
            int old = k;

            Iterator<Person> iterable = scoreList.iterator();
            int sum = 0;
            Person[] persons = new Person[scoreList.size()];
            scoreList.toArray(persons);
            Arrays.sort(persons, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o2.score - o1.score;
                }
            });
            for (int i = 0; i < persons.length && i < k; i++) {
                System.out.print(persons[i].score + " ");
                sum += persons[i].score;
            }
            System.out.println();
            System.out.println("top K" + old + " sum:" + sum);
            return sum;
        }

        public void reset(int playerId) {
            System.out.println("reset : " + playerId);
            Person person = null;
            Iterator<Person> iterable = scoreList.iterator();
            while (iterable.hasNext()) {
                Person temp = iterable.next();
                if (temp.id == playerId) {
                    person = temp;
                    break;
                }
            }
            if (person == null) {
                System.out.println("reset : " + playerId + " not found");
                return;
            } else {
                // person.score = 0;
                System.out.println("reset : " + playerId + " removed");
                scoreList.remove(person);
            }
        }

        private class Person {
            int id;
            int score;

            public Person(int id, int score) {
                this.id = id;
                this.score = score;
            }

        }
    }

}
