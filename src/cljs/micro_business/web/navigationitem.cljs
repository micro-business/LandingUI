(ns micro-business.web.navigationitem
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]))

(defn getNavItemStyle [{:keys [href]}]
  (if-let [hrefValue href]
    #js {:href hrefValue}
    #js {}))

(defn getNavItem [{:keys [caption href]}]

(dom/li
nil

  (dom/a (getNavItemStyle {:href href}) caption)))

(defui NavItem
  static om/IQuery
  (query [this]
         '[:caption :href])
  Object
  (render [this]
          (getNavItem {:caption (-> this om/props :caption)
                       :href (-> this om/props :href)})))

(def navItem (om/factory NavItem))
