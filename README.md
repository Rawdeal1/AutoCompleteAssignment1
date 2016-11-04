# AutoCompleteAssignment1

This an autocomplete program that uses a bruteforce method to recomend words.

It contains three options 1) User enters a word and the program will return the weight. 2) User enters a partial word and the program will return the best match 3) User enters a patial word and a number of suggestions desired and the program will return that many suggestions back

Testing Strategy. I used junit tests to test my program. I tested the methods that get the result by using assert equals. For example to test the "weightOf" method I used the following code

  assertEquals(703754300,auto.weightOf("as"),0.01);

The first value is the result I expect back from the method. The string ("as") is the input and the 0.01 is the acceptable margin of error between the expected answer and the actual answer

This is the same technique used for the rest of the code
