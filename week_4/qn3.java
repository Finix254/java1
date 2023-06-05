//package week_4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class qn3 {

    public static void main(String[] args) {
         /* You don't need to modify this main method but it won't affect the
        tests if you do. You may wish to add or modify this method to help test
        your new code.
        */

        // Create new ArrayList to contain names of movies to watch
        List<String> movieWatchList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter name of movie to watch");
            String newMovieName = scanner.nextLine();
            addMovie(newMovieName, movieWatchList);
        } while (yesNoInput(scanner, "Add more movies?"));

        String nextMovie = getNextMovie(movieWatchList);
        if (nextMovie != null) {
            System.out.println("The next movie to watch is " + nextMovie);
        } else {
            System.out.println("There are no movies in the watchlist.");
        }

        String randomMovie = getRandomMovieFromWatchList(movieWatchList);
        if (randomMovie != null) {
            System.out.println("A random movie from the list is " + randomMovie);
        } else {
            System.out.println("There are no movies in the watchlist.");
        }

        System.out.println("Enter the name of a movie to remove");
        String movieToRemove = scanner.nextLine();
        removeMovie(movieToRemove, movieWatchList);

        System.out.println("\n ** All movies, in order to watch **\n");
        printMoviesInWatchListOrder(movieWatchList);

        System.out.println("\n ** All movies, in name order **\n");
        printMoviesInNameOrder(movieWatchList);
    }

    public static void addMovie(String movie, List<String> movies) {
        /* Part 1.
        TODO finish this method.
        This method should add the String movie to the END of the movies List,
        but only if the movie is not in the list.
        Don't change the case of the movie string when adding it to the movies list.
        If the movie is 'WALL-E' then add this exact string.
        If the movie is 'Star Wars: Episode IV – A New Hope' add this exact string.
        If the movies list contains ['Up', 'Jaws', 'Spiderman']
        and the movie String is 'Rocky' then it should be added to the end of the list.
        The movies list will become ['Up', 'Jaws', 'Spiderman', 'Rocky']
        Print the message "Movie added!"
        Don't add the movie if it is already in the movies list.
        Your check should be case-insensitive.
        If the movies list contains ['Up', 'Jaws', 'Spiderman']
        and if the movie String is 'Up' then it should NOT be added.
        or, if the movie String is 'up' then it should NOT be added.
        or, if the movie String is 'UP' then it should NOT be added.
        If the movie is already in the list, print the message "This movie is already in your watchlist!"
        This method does not need to return anything.
         */
        if (movies.contains(movie)) {
            System.out.println("This movie is already in your watchlist!");
        } else {
            movies.add(movie);
            System.out.println("Movie added!");
        }
    }

    public static String getNextMovie(List<String> movies) {
         /* Part 2.
        TODO finish this method.
         If the movies list is not null, and has as at least one movie in it,
         return the first movie in the list.
         Don't modify the movies list.
         If the movies list is null, or empty, return null.
         Hint: check if the list is null or empty first.
         */
        if (movies == null || movies.isEmpty()) {
            return null;
        } else {
            return movies.get(0);
        }
    }

    public static void removeMovie(String movie, List<String> movies) {
        /* Part 3.
         TODO finish this method.
         Remove the movie from the movies list.
         Your check should be case-insensitive.
         If the movie is in the movies list, remove that movie and print the
         message "Movie removed!"
         If the movies list contains ['Up', 'Jaws', 'Spiderman']
         and the movie String is 'Jaws' then the 'Jaws' entry in the list should be removed.
         or if the movie String is 'jaws' then the 'Jaws' entry in the list should be removed.
         or if the movie String is 'JAWS' then the 'Jaws' entry in the list should be removed.
         Print the message "Movie removed!"
         If the movies list contains ['Up', 'Jaws', 'Spiderman']
         and the movie String is 'Rocky' then don't modify the movies list
         Print the message "Movie not found!"
         If the movies list is null, or empty, print the message "Movie not found!"
         Hint: check if the list is null or empty first.
         */
        if (movies == null || movies.isEmpty()) {
            System.out.println("Movie not found!");
        } else {
            String movieToRemove = null;
            for (String m : movies) {
                if (m.equalsIgnoreCase(movie)) {
                    movieToRemove = m;
                    break;
                }
            }
            if (movieToRemove == null) {
                System.out.println("Movie not found!");
            } else {
                movies.remove(movieToRemove);
                System.out.println("Movie removed!");
            }
        }
    }

    public static void printMoviesInWatchListOrder(List<String> movies) {
        /*
         Part 4.
        TODO finish this method.
         Return the name of a random movie from the movies list.
         Don't modify the movies list.
         If the movies list is null, or empty, return null.
         Hint: check if the list is null or empty first.
         */
        if (movies == null || movies.isEmpty()) {
            System.out.println("There are no movies in the watchlist.");
        } else {
            for (String m : movies) {
                System.out.println(m);
            }
        }
    }

    public static void printMoviesInNameOrder(List<String> movies) {
         /* Part 5.
        TODO finish this method.
         Print the movie names in alphabetical order, one movie per line.
         ** Don't modify the original movies list! **
         If the movies list contains ['Up', 'Jaws', 'Spiderman'] you will
         print
         Jaws
         Spiderman
         Up
         You should sort the movies using Java's default sort order for strings,
         and print the exact text of the movie names from the list.
         If the movies list contains ['Up', 'jaws', 'Spiderman']
         Note 'jaws' has lowercase 'j' and lowercase letters are sorted after
         uppercase letters.
         you will print
         Spiderman
         Up
         jaws
         If the movies list is empty or null, print the message 'No movies'
         This method will not return anything.
         */
        if (movies == null || movies.isEmpty()) {
            System.out.println("There are no movies in the watchlist.");
        } else {
            List<String> sortedMovies = new ArrayList<>(movies);
            sortedMovies.sort(String.CASE_INSENSITIVE_ORDER);
            for (String m : sortedMovies) {
                System.out.println(m);
            }
        }
    }

    public static boolean yesNoInput(Scanner scanner, String prompt) {
        System.out.println(prompt + " (y/n)");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }

    public static String getRandomMovieFromWatchList(List<String> movies) {
        if (movies == null || movies .isEmpty()) {
            return null;
            } else {
            int randomIndex = (int) (Math.random() * movies.size());
            return movies.get(randomIndex);
            }
            }
            }
       