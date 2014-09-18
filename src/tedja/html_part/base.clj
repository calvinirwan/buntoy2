(ns tedja.html-part.base
  (:require [selmer.parser :as parser]
            [clojure.string :as s]
            [ring.util.response :refer [content-type response]]
            [compojure.response :refer [Renderable]]
            [environ.core :refer [env]]
            [net.cgrand.enlive-html :refer :all]
            [hiccup.form :as f]
            [tedja.utils :refer [render]]))



(def judul [:div [:h3#judul "Hello worls"]])

(def form (f/form-to [:post "/login"]
             (f/text-field {:placeholder "username" :required true} :username)[:br]
             (f/password-field {:placeholder "password" :required true} :password)[:br]
             (f/radio-button :preferensi false "tata")[:br]
             (f/radio-button :preferensi false "tedja")[:br]
             (f/submit-button :login)
             [:p
              (f/label "radio"  "radio")
              (f/radio-button 1 false 1)
              (f/radio-button 1 true 2)]
             [:input {:type "text"
                      :name "hasu"
                      :id "hasu"
                      :value 42} "lebron"]))

(def page (content (html [:div judul form])))

(defsnippet first-snip "templates/unlive.html"
  [:header]
  [heading navigation-elements]
  [:h1] (content heading)
  [:ul [:li first-of-type]] (clone-for [[caption url] navigation-elements]
                                                 [:li :a] (content caption)
                                                 [:li :a] (set-attr :href url)))

(deftemplate main-template "templates/enlive.html"
  []
  [:head :title] (html-content "Enlive starter kit")
  [:body] page)
