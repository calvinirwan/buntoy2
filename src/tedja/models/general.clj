(ns tedja.models.general
  (:require [compojure.core :refer :all]
            [tedja.layout :as layout]
            [tedja.util :as util]
            [tedja.html-part.part :as part]
            [com.ashafa.clutch :as asha]))

(def db "test")

(defn get-db [db] (asha/get-database db))

(def users
  [{:type "user" :username "calvin" :password "lebron"}
    {:type "user" :username "calvin1" :password "lebron1"}
    {:type "user" :username "calvin2" :password "lebron2"}
    {:type "user" :username "calvin3" :password "lebron3"}])
(defn calvin []  "i love me")
