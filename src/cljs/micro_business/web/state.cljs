(ns micro-business.web.state)

(def applicationGlobalState
  {:app/navigationContext {:brand "Micro Business"
                           :rightToLeftAlignment false
                           :navigationItems [{:caption "Login" :href "#login"}]}})
