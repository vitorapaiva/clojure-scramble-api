(ns scrambler.core-test
    (:require [clojure.test :refer :all]
      [scrambler.core :refer :all]))

(deftest if-strings-are-equal-return-true
         (is (= (return-scrambled-string "test" "test") true)))

(deftest if-haystack-is-smaller-than-needle-return-false
         (is (= (return-scrambled-string "te" "test") false)))

(deftest if-haystack-has-needle-than-return-true
         (is (= (return-scrambled-string "test" "tes") true)))

(deftest if-haystack-has-needle-in-different-order-than-return-true
         (is (= (return-scrambled-string "test" "ttse") true)))

(deftest if-haystack-does-not-have-needle-than-return-false
         (is (= (return-scrambled-string "test" "ttsa") false)))