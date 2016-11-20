(ns micro-business.web.state)

(def applicationGlobalState
  {:app/navigationContext {:brand "Micro Business"
                           :navigationItems [{:caption "Login" :href "#login"}
                                             {:caption "Contact" :href "#contact"}]}})
