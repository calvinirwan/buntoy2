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
   {:type "user" :username "vina" :password "zeneng"}
   {:type "user" :username "tedja" :password "tedja"}
   {:type "user" :username "a" :password "a"}])
(defn calvin []  "i love me")
