(ns scrambler.core
    (:require [org.httpkit.server :as server]
          [clojure.string :as str])

(defn return-scrambled-string [haystack needle]
      haystack-length = count (haystack)
      (cond
            (= haystack needle) true
            (<= (count haystack) (count needle) ) false
            :else
            (for [counter (range haystack-length)]

                 )))




