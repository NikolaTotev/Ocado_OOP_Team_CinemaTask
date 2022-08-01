## `cinema` - Descibe a cinema domain in Java

---

You should describe a real world cinema as a set of interconnected objects.

There are multiple movies in the cinema. Each of them has a `genre`, `length in minutes`, `actors` and `director`.

There are also a couple of Viewing rooms in the cinema. Each room has a `room number`, `seats` and plays multiples movies across a single day. Every room works from `16:00-23:50`. 

Reservations could be made for watching a particular movie at a particular time selected by the users.

---
**listProjections:** You need to create a class `Cinema` that represents a real cinema and handles movies, projections, reservations, etc... You should implement a method `ListProjections()` that list all the available projection hours for each movie for the current day.

**createReservation:** There should be a public method `createReservation(...)` that creates a unique reservation for user-selected seats for a user-selected movie, that starts at a certain time. Reservation duplications must be avoided.

**getAvailableSeatsForMovieAndTime** There should be a public method `getAvailableSeatsForMovieAndTime(...)` that does exactly as it says.

**listProjections:** There should also be methods to list all of the available movies by genre, by director and by actors. It is up to you whether you want to overload this method or create new ones.  

**addNewMovie:** Adds a new movie to be projected if it can fit it in any viewing room. There needs to be at least 30 minutes between any two movies projected in a viewing room.

**removeLeastProfitableMovie:** `removeLeastProfitableMovie()` - Stop projecting the least profitable movie in the cinema.

**getTotalRevenue:** Return the total amount of money made by reservations.



