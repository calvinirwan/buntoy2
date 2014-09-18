(ns tedja.html-part.base
  (:require [selmer.parser :as parser]
            [clojure.string :as s]
            [ring.util.response :refer [content-type response]]
            [compojure.response :refer [Renderable]]
            [environ.core :refer [env]]
            [net.cgrand.enlive-html :as h]
            [hiccup.form :as f]))

(h/deftemplate main-template "templates/enlive.html"
  []
  [:head :title] (h/html-content "Enlive starter kit"))

(h/defsnippet first-snip "templates/unlive.html"
  [:header]
  [heading navigation-elements]
  [:h1] (h/content heading)
  [:ul [:li h/first-of-type]] (h/clone-for [[caption url] navigation-elements]
                                                 [:li :a] (h/content caption)
                                                 [:li :a] (h/set-attr :href url)))
