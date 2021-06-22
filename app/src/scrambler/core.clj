(ns scrambler.core
    (:require [org.httpkit.server :as server]
      [clojure.string :as str]))

(defn return-scrambled-string [haystack needle]
      (cond
        (= haystack needle) true
        (<= (count haystack) (count needle)) false
        (= (doseq [needle-char (seq needle)]
                  (cond
                    (= (some #{needle-char} (seq haystack)) nil) false)) false) false
        :else
        true))
