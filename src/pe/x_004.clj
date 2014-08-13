(ns pe.x-004)

; A palindromic number reads the same both ways. The largest palindrome made from the 
; product of two 2-digit numbers is 9009 = 91 × 99.

; Find the largest palindrome made from the product of two 3-digit numbers.

(apply 
  max 
  ((fn [a b acc]
     (if (> a 99)
       (if (= (str (* a b)) (clojure.string/reverse (str (* a b))))
         (recur (dec a) (dec a) (cons (* a b) acc))
         (if (= b 99)
           (recur (dec a) (dec a) acc)
           (recur a (dec b) acc)))
       acc)) 999 999 '()))