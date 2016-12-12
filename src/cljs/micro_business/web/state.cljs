(ns micro-business.web.state
  (:require
   [micro-business.web.landingpage.state :as landingpage]
   [micro-business.singlesignon.signinpage.state :as signinpage]))

(def state
  {:landing-pages landingpage/state
   :signin-page signinpage/state})
