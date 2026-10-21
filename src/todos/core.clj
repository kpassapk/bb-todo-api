(ns todos.core
  "The todo model. A store is a plain map; every function is pure and
  returns a new store, so there is no I/O here.")

(def empty-store {:next-id 1 :todos {}})

(defn add
  "Add a todo titled TITLE. Returns [store todo]."
  [store title]
  (let [id   (:next-id store)
        todo {:id id :title title :done? false}]
    [(-> store
         (assoc-in [:todos id] todo)
         (update :next-id inc))
     todo]))

(defn all
  "Every todo, oldest first."
  [store]
  (sort-by :id (vals (:todos store))))
