(ns tedja.utils
  (:require [selmer.parser :as parser]
            [clojure.string :as s]
            [ring.util.response :refer [content-type response]]
            [compojure.response :refer [Renderable]]
            [environ.core :refer [env]]
            [net.cgrand.enlive-html :as h]
            [hiccup.form :as f]))

(defn render [text]
  (apply str text))

(h/deftemplate main-template "templates/enlive.html"
  []
  [:head :title] (h/html-content "Enlive starter kit"))
