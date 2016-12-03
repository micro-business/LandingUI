(ns micro-business.web.state
  (:require
   [micro-business.web.landingpage.state :as landingpage]))

(def state
  {:landing-pages landingpage/state})
