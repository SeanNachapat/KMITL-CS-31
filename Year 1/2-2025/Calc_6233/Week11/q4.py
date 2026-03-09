import numpy as np
from scipy.integrate import odeint

def model(L, t):
    dLdt = np.exp(-0.05 * t) * np.cos(3 * t)
    return dLdt

L0 = 0
t = np.linspace(0, 100, 101)
L = odeint(model, L0, t).ravel()

print("Training Epochs\tLoss Value")
for ti, li in zip(t, L):
    print(f"{ti:.2f}\t\t{li:.6f}")
