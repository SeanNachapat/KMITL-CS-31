import numpy as np
from scipy.integrate import odeint

def model(B, t):
    k = 0.05
    V = 50
    dBdt = -k * B + V * np.sin(np.pi * t / 12)
    return dBdt

B0 = 1000
t = np.linspace(0, 48, 49)
B = odeint(model, B0, t).ravel()

print("Time (hours)\tBattery Level (mAh)")
for ti, bi in zip(t, B):
    print(f"{ti:.2f}\t\t{bi:.4f}")
