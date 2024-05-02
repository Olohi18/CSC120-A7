Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
Cafe: Constructor(2), sellCoffee(2); restock(2): I reasoned that in a Cafe, there's usually the option to get coffe without sugar, so I implemented an overloaded sellCoffee method to do that. For the restock methods, I made a default restock() that automatically sets everything in the inventory to a given value. However, since this won't be neccessary everytime, I wanted a function that allows restocking based on the items unavailable, so I overloaded the default restock method to do that. Finally, for the constructors, I created a constructor to simply make a default amount of coffee. If a customer decides they want a different size or want an ingredient different from the typical, the salesperson can use the overloaded form of the constructor to deliver as requested.

House: Overloaded moveIn and moveOut--- My reasoning behind these was that I should be able to move at least three persons into a house at once. If the number of persons to be added is less than 3, then we can simply use the default methods to add individually. However, I wonder if it's possible to add infinitely many people at once-- I will like ot know your thoughts on this @Johanna @Jordan-- Feel free to provide your comments on my assignment feedback. Thanks!

Library: Overloaded addTitle, removeTitle, checkOut, returnBook, containsTitle. I overloaded these methods for reasons similar to why i overloaded the moveIn and moveOut methods in the House class. It will be helpful to be able to do it with an unrestricted number of books though.


- What worked, what didn't, what advice would you give someone taking this course in the future?

I was quite sluggish about this assignment because I thought taking it at a very relaxed pace will make me learn more as I work through the assignment. However, I realized because of that, I wasn't proactive and finished too late (on Thursday) to even try the kudos section.
My advice: Be proactive! You do not have all the time in the world.

Side note---- So we can't create two different overloaded methods with just "name" for one and "address" for another in a constructor