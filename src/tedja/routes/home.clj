(ns tedja.routes.home
  (:require [compojure.core :refer :all]
            [tedja.layout :as layout]
            [tedja.util :refer [render]]
            [tedja.html-part.part :as part]
            [tedja.html-part.base :as base]
            [tedja.cooking.part :as cook]))

(defn home-page []
  (layout/render
    "home.html" {:content (util/md->html "/md/docs.md")}))

(defn about-page []
  (layout/render "about.html"))

(defn photos-page []
  (layout/render "photos.html"))

(defn curhat-page []
  (layout/render "photos.html"
                 {:content (part/curhatan)
                  :curhat (part/curhat)}))

(defn login-page []
  (layout/render "photos.html"
                 {:content (part/login-container)
                  :curhat (part/curhat)}))

(defn login-post-page [username password]
  (layout/render "photos.html"
                 {:content (cook/login-post username password)
                  :curhat (part/curhat)}))

(defn enlive []
  (render (base/main-template)))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/photos" [] (photos-page))
  (GET "/curhat" [] (curhat-page))
  (GET "/enlive" [] (enlive))
  (GET "/login" [] (login-page))
  (POST "/login" [username password] (login-post-page username password)))
