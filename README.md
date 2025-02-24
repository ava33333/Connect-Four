## Connect Four Program

### Overview: Briefly describe what your program does.  
My program is an interactive connect four inspired game. Instead of tokens, it uses Xs and Os to mark each players token, one player being X and the other being O. Helper methods displayBoard, makeMove, checkWinner, isBoardFull, and switchPlayer are called at various times to create cohesive gameplay. The displayBoard function is called and then winCheck and boardFull boolean variables are initialized to enter the while loop. The while loop first outputs which player is starting, which is initially X. After that, it asks the player to enter the column they want to place their piece in, using Scanner. The makeMove function is called with the number that was input by the user, and then the displayBoard, which will output the updated board. Then, the winCheck and boardFull variables are updated, so that the loop will stop if either of them are flipped (if winCheck is true or boardFull is false). Before running through the loop again, the variables are checked to switch to the other player. This is so that the loop will start with player X and will also output the correct player when outputting who won (if applicable). After the loop, boardFull is checked. If it is false, then the computer outputs that it was a draw, otherwise, it outputs what player won. The scanner is closed at the end of the method.

### Usage: Instructions on how to compile and run the program.  
To compile and run the program, make sure you have Java downloaded, then you can upload the file to an IDE that compiles Java. I used Eclipse, but any IDE as specified should work. Once you have uploaded it, you should be able to play Connect Four by running the program. You can then input which column you would like to place your piece in and the next player will be prompted to do the same after your turn. Though it is best to play with two players, you can play by yourself as both "X" and "O".

### License: Appropriate license notification.
MIT License

Copyright (c) 2025 Ava McDonald

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

### Author: 
Ava McDonald

