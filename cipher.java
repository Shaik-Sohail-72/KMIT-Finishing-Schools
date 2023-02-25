/*n encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:

If the character read is a letter, that letter is written onto the tape.
If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.

 

input =leet2code3
10
output =o


Explanation:
Input: S = "leet2code3",  K = 10
Output: "o"
 The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".


Example 2:
input =ha22
5
output =h

Explanation
Input: S = "ha22", K = 5
Output: "h"

The decoded string …
[2:44 pm, 19/01/2023] Q.Q Saif M: Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc

For example, the given cleartext s = There's-a-starman-waiting-in-the-sky and the alphabet is rotated by k=3. The encrypted string is Wkhuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb.

Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted. 

input =11
middle-Outz
2
output =
okffng-Qwvb


Explanation

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab

m -> o
i -> k
d -> f
d -> f
l -> n
e -> g
-    -
O -> Q
u -> w
t -> v
z -> b

*/