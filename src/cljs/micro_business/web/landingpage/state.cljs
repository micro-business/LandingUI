(ns micro-business.web.landingpage.state)

(def ^:private navigationBar {:brand "Micro Business"
                              :rightToLeftAlignment false})

(def ^:private signedInNavigationItems {:navigationItems
                                        [{:id 'signout :caption "Sign out" :onClickedQueryExpression `[('signout/clicked) :current-state]}]})

(def ^:private signedOutNavigationItems {:navigationItems
                                         [{:id 'signin :caption "Sign in" :onClickedQueryExpression `[('signin/clicked) :current-state]}]})

(def state
  [{:id :landingPage/signedIn
    :navigationBars [(merge {:id 'topNavigationBarSignedIn} navigationBar signedInNavigationItems)]}

   {:id :landingPage/signedOut
    :navigationBars [(merge {:id 'topNavigationBarSignedOut} navigationBar signedOutNavigationItems)]}])
