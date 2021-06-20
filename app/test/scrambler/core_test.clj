(ns scrambler.core-test
    (:require [clojure.test :refer :all]
      [scrambler.core :refer :all]))

(deftest if-strings-are-equal-return-true
         (is (= (return-scrambled-string "test" "test") true)))

(deftest if-haystack-is-smaller-than-needle-return-false
         (is (= (return-scrambled-string "te" "test") false)))


