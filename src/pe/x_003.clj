(ns pe.x-003)

; The prime factors of 13195 are 5, 7, 13 and 29.

; What is the largest prime factor of the number 600851475143 ?

(defn get-max-prime-factor [number current]
  (if (= number current)
    number
    (if (zero? (mod number current))
      (get-max-prime-factor (/ number current) current)
      (get-max-prime-factor number (inc current)))))

; (get-max-prime-factor 600851475143 2)