(ns todos.core-test
  (:require
   [clojure.test :refer [deftest is]]
   [todos.core :as core]))

(deftest add-test
  (let [[store a] (core/add core/empty-store "write docs")
        [store b] (core/add store "ship it")]
    (is (= {:id 1 :title "write docs" :done? false} a))
    (is (= 2 (:id b)))
    (is (= ["write docs" "ship it"] (map :title (core/all store))))))
